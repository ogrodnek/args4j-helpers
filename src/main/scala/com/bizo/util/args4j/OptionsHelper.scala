package com.bizo.util.args4j

import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import scala.collection.JavaConverters._
import org.kohsuke.args4j.NamedOptionDef

trait OptionsWithHelp {
  import org.kohsuke.args4j.Option
  
  @Option(name="--help", aliases=Array("-h"), usage="show this message")
  var help = false
}

object OptionsHelper {
  def optionsOrExit[T <: OptionsWithHelp](args: Array[String], options: T): T = {
    val parser = new CmdLineParser(options)
    
    try {
      parser.parseArgument(args : _*)
      
      if (options.help) {
        parser.printUsage(System.err)
        sys.exit(0)
      }
      
    } catch {
      case e: CmdLineException => {
        // required arguments not present, or parsing error.  Check to see if help was requested
        val help = e.getParser.getOptions.asScala.find { o =>
          o.option match {
            case n: NamedOptionDef => n.name == "--help"
            case _ => false
          }
        }
        
        for (h <- help if h.setter.asFieldSetter.getValue == true) {
          parser.printUsage(System.err)
          sys.exit(0)
        }
        
        // missing required var and help not requested
        System.err.println(e.getMessage)
        parser.printUsage(System.err)
        sys.exit(1)
      }
    }
    
    options
  }  
}
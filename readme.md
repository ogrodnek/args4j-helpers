# args4j-helpers

[![Build Status](https://travis-ci.org/ogrodnek/args4j-helpers.svg?branch=master)](https://travis-ci.org/ogrodnek/args4j-helpers)

Simple helper for command-line parsing using [args4j](http://args4j.kohsuke.org/).

Args4j is a fantastic parsing library, but there's typically a lot of boilerplate for dealing with printing usage and dealing with parse errors.

This library encapsulates typical option parsing error handling:

* If help (provided via `OptionWithHelp` base trait bound to `--help` and `-h`) is requested, print usage information to stderr, exit with code `0`.
* If a required option is missing (`required=true`), print usage information to stderr, exit with code `1` (unless help was requested).


## Usage

Define your options class normally, extending `OptionsWithHelp`

```
class MyOptions extends OptionsWithHelp {
  @Option(name="--blah", aliases=Array("-b"), usage="some val", metaVar="BLAH")
  var blah: Int = 0
}
```

retrieving/parsing becomes a single line

```
import OptionHelper.optionsOrExit

def main(args: Array[String]) {
  val options = optionsOrExit(args, new MyOptions)
  
  println(s"blah is ${options.blah}")
}
```

## License

[Apache 2 License](http://www.apache.org/licenses/LICENSE-2.0.html)
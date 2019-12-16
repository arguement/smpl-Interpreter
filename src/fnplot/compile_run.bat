
title Compiles and runs java files

rem this is an explanation

javac -d bin gui\*.java semantics\*java syntax\*.java sys\*java values\*.java syntax\inbuiltfunctions\*.java -cp ".;syntax\java-cup-11b-runtime.jar;gui\cs34q-utils.jar" && java -cp "bin;gui\cs34q-utils.jar;syntax\java-cup-11b-runtime.jar" fnplot.gui.FnPlotFrame


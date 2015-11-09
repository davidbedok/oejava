@echo off
call set.bat
echo JAVA BIN: %JAVA_BIN%
%JAVA_BIN%\javac -d ./bin ./src1/hu/qwaevisz/demo/HelloWorld.java ./src2/hu/qwaevisz/demo/HelloTest.java
echo compile complete
@echo off
call set_jdk.bat
echo JAVA BIN: %JAVA_BIN%
%JAVA_BIN%\javac ../hu/qwaevisz/demo/HangCompile.java
echo compile complete
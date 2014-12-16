#!/bin/sh

#This shell script builds and creates a runnable OS X app based on the contents
#Of the ./source/app.nw/ and ./source/icons/ folders.

#The name of the folder in the ./bin/
nodewebkitversion="node-webkit-v0.11.2-osx-x64"
here="`dirname \"$0\"`"
echo "cd-ing to $here"
cd "$here" || exit 1

cd ./source/app.nw/
zip -r -X app.nw *
cp app.nw ../../build/
cp app.nw ../../bin/$nodewebkitversion/node-webkit.app/Contents/Resources/
rm app.nw

cd ../icons/
cp nw.icns ../../bin/$nodewebkitversion/node-webkit.app/Contents/Resources/

cd ..
cp Info.plist ../bin/$nodewebkitversion/node-webkit.app/Contents/

cd ..
# `setfileicon` is an OS X application for setting the icon of files and folders
setfileicon bin/$nodewebkitversion/node-webkit.app/Contents/Resources/nw.icns bin/$nodewebkitversion/node-webkit.app


#!/bin/sh

#This shell script builds and creates a runnable OS X app based on the contents
#Of the ./source/app.nw/ and ./source/icons/ folders.

#The name of the folder in the ./bin/
nodewebkitversion="node-webkit-v0.11.2-osx-x64"
here="`dirname \"$0\"`"
echo "cd-ing to $here"
cd "$here" || exit 1
cd ..

echo "Building app to ./build/app.nw ..."

cd ./source/app.nw/
zip -r -X app.nw *
cp app.nw ../../build/
rm app.nw

echo "Done."

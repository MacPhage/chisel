#!/bin/sh
here="`dirname \"$0\"`"
echo "cd-ing to $here"
cd "$here" || exit 1
cd ./source/app.nw/

zip -X app.nw *
cp app.nw ../../build/
rm app.nw


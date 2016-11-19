#!/usr/bin/env bash
rm ../api.html
echo rm ../api.html

rm ../html/*
echo rm ../html/*

ls *.md | xargs cat >> ../api.md

ls *.md | xargs -i{} basename {} .md | xargs -i{} grip {}.md --export ../html/{}.html

grip ../api.md --export ../api.html
echo grip ../api.md --export ../api.html

rm ../api.md
echo rm ../api.md
#
#for file in `ls *.md | xargs -i{} basename {} .md`
#do
#    echo "<a href='$file.html'>$file</a><br>" >> ../html/index.html
#done
#echo "<a href='api.html'>api</a>" >> ../html/index.html
#!/bin/bash
files=$(find . -type f -name "*.tar.gz")
          if [ -z "$files" ]; then
            echo "Keine .tar.gz-Dateien gefunden."
            echo "files=" >> $GITHUB_OUTPUT
          else
            echo "Gefundene Dateien:"
            echo "$files"
            echo "files<<EOF" >> $GITHUB_OUTPUT
            echo "$files" >> $GITHUB_OUTPUT
            echo "EOF" >> $GITHUB_OUTPUT
          fi
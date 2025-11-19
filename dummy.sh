#!/bin/bash
 echo "Erzeuge Dummy-Datei (5 MB)…"
          dd if=/dev/zero of=dummy.bin bs=1M count=5
          tar -czf test.tar.gz dummy.bin
          rm dummy.bin
          echo "Dummy-Datei test.tar.gz erzeugt."
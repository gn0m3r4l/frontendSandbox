#!/bin/bash
 echo "Erzeuge Dummy-Datei (5 MB)…"
  dd if=/dev/zero of=dummy.bin bs=1M count=5
  dd if=/dev/zero of=dummy2.bin bs=1M count=5

  tar -czf test.tar.gz dummy.bin
  tar -czf test2.tar.gz dummy2.bin
  rm dummy.bin
  rm dummy2.bin
  echo "Dummy-Datei test.tar.gz erzeugt."
#!/usr/bin/env bash

npm test

if [["$?" == 0]]; then
  echo
  echo "Unit tests all passed!"
  echo
  exit 0
else
  echo
  echo "Unit tests failed! Code not commited >:-o"
  echo
  exit 1
fi

# chmod 744 pre-commit
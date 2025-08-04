#!/bin/bash

npm install;
pm2 delete travel-web;
pm2 start npm --name travel-web -i max -- run dev;

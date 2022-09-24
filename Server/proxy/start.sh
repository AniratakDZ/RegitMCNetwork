screen -d -m -S Proxy bash -c
#!/bin/sh
while true
do
sudo -Xms1G -Xmx1G --illegal-access=permit -jar proxy.jar
for i in 5 4 3 2 1
do
  echo "Starte neu in $1"
  sleep 1
  done
  echo "Startet!"
  done
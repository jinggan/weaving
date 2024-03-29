#! /bin/bash
#添加tortoisehg和mercurial的源
sudo add-apt-repository ppa:tortoisehg-ppa/releases
sudo add-apt-repository ppa:mercurial-ppa/releases
sudo apt-get update
#安装tortoisehg和mercurial的源
sudo apt-get install mercurial python-nautilus tortoisehg
#集成nautilus
mkdir -p ~/.nautilus/tortoisehg/src/ && cd ~/.nautilus/tortoisehg/src/
hg clone https://bitbucket.org/tortoisehg/stable tortoisehg
mkdir -p ~/.nautilus/python-extensions/
ln -s ~/.nautilus/tortoisehg/src/tortoisehg/contrib/nautilus-thg.py ~/.nautilus/python-extensions/
#安装sun-jdk
sudo apt-get install default-jdk maven
#打开Firefox查看Google Code页面如何来下代码
firefox http://code.google.com/p/friendmap/source/checkout


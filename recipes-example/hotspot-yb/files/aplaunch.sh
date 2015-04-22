#!/bin/sh
#Comment this line if you don't want the logs.
set -x
echo Wait a few seconds for the USB to be ready
sleep 20
echo Initialising wireless interface
ifconfig wlan0 inet 192.168.11.65
echo Starting DHCP server
/usr/sbin/udhcpd -f -S /etc/udhcpd.conf.yb &
echo Launching Access Point
/usr/sbin/hostapd /etc/hostapd.conf.yb
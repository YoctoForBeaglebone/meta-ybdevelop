SUMMARY = "Packagegroup For our layer YB-Develop"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = " \
	helloworld\
"
#	pacman4console


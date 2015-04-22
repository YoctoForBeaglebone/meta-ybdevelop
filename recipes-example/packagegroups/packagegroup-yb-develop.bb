SUMMARY = "Packagegroup For our layer YB-Develop"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = " \
	helloworld \
	pacman4console \
	v4l-utils \
	yavta \
	gst-ffmpeg \
	gstreamer \
	gst-plugins-good-meta \
	gst-plugins-good \
	gst-plugins-base \
	gst-plugins-bad \
	gst-plugins-ugly \
"

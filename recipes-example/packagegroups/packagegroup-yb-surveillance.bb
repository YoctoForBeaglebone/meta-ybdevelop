SUMMARY = "Packagegroup For Survailance related packages"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = " \
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

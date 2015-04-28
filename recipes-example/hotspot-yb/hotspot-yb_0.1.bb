DESCRIPTION = "Copy all of the configuration Files to the rootfs"
SECTION = "Networking"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit systemd

SYSTEMD_SERVICE_${PN} = "ap.service"
SYSTEMD_AUTO_ENABLE = "enable"

SRC_URI = " \
	file://ap.service \
	file://aplaunch.sh \
	file://hostapd.conf.yb \
	file://udhcpd.conf.yb \
	file://udhcpd.leases \
	file://carl9170.conf \
	file://setup-gw.sh \
	"

# hostapd.conf.yb udhcpd.conf.yb udhcpd.leases

do_install_append() {
   if ${@base_contains('DISTRO_FEATURES','systemd','true','false',d)}; then
      install -d ${D}${sysconfdir}
      install -m 644 ${WORKDIR}/hostapd.conf.yb ${D}${sysconfdir}
      install -m 644 ${WORKDIR}/udhcpd.conf.yb ${D}${sysconfdir}
      install -m 644 ${WORKDIR}/carl9170.conf ${D}${sysconfdir}/modprobe.d/
      install -d ${D}${OPKGLIBDIR}/misc/
      install -m 644 ${WORKDIR}/udhcpd.leases ${D}${OPKGLIBDIR}/misc/
      install -d ${D}${systemd_unitdir}/scripts
      install -m 755 ${WORKDIR}/aplaunch.sh ${D}${systemd_unitdir}/scripts/
      install -m 755 ${WORKDIR}/setup-gw.sh ${D}${systemd_unitdir}/scripts/
      install -d ${D}${systemd_unitdir}/system
      install -m 644 ${WORKDIR}/ap.service ${D}${systemd_unitdir}/system/
   fi
}

FILES_${PN} += "${systemd_unitdir}/scripts ${sysconfdir} ${OPKGLIBDIR}"

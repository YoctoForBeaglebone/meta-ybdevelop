FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.12:"

SRC_URI_append = " \
            zexel.cfg \
            rfkill.cfg \
"

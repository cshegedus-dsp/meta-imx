# Copyright 2021 NXP
DESCRIPTION = "i.MX HANTRO V4L2 Daemon"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=cd8bc2a79509c22fc9c1782a151210b1"

SRC_URI = "${FSL_MIRROR}/${BPN}-${PV}.tar.gz"

SRC_URI[md5sum] = "47c0756ea580995ed961b2ea75874eab"
SRC_URI[sha256sum] = "32c37db0204e40b11329f2112eb5cae41aed47166021da15b6eccacbbc539055"

DEPENDS += "imx-vpu-hantro"
DEPENDS_append_mx8mp = " imx-vpu-hantro-vc"

PLATFORM_mx8mm = "IMX8MM"
PLATFORM_mx8mq = "IMX8MQ"
PLATFORM_mx8mp = "IMX8MP"

EXTRA_OEMAKE += " \
                  CROSS_COMPILE="${HOST_PREFIX}" \
                  SDKTARGETSYSROOT="${STAGING_DIR_TARGET}" \
                  CTRLSW_HDRPATH="${STAGING_DIR_TARGET}"/usr/include \
"
do_compile () {
    oe_runmake PLATFORM="${PLATFORM}" all
}

do_install () {
    oe_runmake DEST_DIR="${D}" PLATFORM="${PLATFORM}" install
}

FILES_${PN} += "/usr/bin"

INSANE_SKIP_${PN} = "ldflags"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"
COMPATIBLE_MACHINE = "(mx8mq|mx8mm|mx8mp)"

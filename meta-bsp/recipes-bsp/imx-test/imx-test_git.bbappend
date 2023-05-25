# Copyright (C) 2012-2016 O.S. Systems Software LTDA.
# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2022 NXP

DEPENDS:append:mx8ulp-nxp-bsp = " imx-lib"
DEPENDS:append:mx9-nxp-bsp = " imx-lib"

SRC_URI = "${IMXTEST_SRC};branch=${SRCBRANCH} \
           file://memtool_profile"
IMXTEST_SRC ?= "git://github.com/nxp-imx/imx-test.git;protocol=https"
SRCBRANCH = "master"
SRCREV = "f45760c598619efa3b335162e8a84141994cb810"

PLATFORM:mx8ulp-nxp-bsp = "IMX8ULP"
PLATFORM:mx9-nxp-bsp = "IMX8ULP"

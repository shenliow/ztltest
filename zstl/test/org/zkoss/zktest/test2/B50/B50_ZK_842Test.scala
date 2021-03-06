package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B50-ZK-842.zul")
class B50_ZK_842Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val intbox = jq(".z-intbox")
        sendKeys(intbox, "-1")
        waitResponse()
        blur(intbox)
        waitResponse()
        verifyTrue("should see an error message.", jq(".z-errorbox").exists())
      })

  }
}

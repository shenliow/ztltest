package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2084.zul")
class B70_ZK_2084Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      List("0.0", "0.0", "0.00").zipWithIndex foreach { case (result, index) =>
        val ds = jq(".z-doublespinner").eq(index).toWidget()
        clickAt(ds.$n("btn-up"), "2,2")
        waitResponse()
        
        clickAt(ds.$n("btn-down"), "2,2")
        waitResponse()
        
        verifyTrue("should see " + result, ds.$n("real").get("value") == result)
      }
    })
    
  }
}
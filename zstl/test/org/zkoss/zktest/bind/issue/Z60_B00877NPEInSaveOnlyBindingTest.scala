/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test
import org.openqa.selenium.Keys

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00877NPEInSaveOnlyBindingTest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00877NPEInSaveOnlyBinding.zul"/>
    }

    runZTL(zul, () => {

      var msg = jq("$msg")
      var tb = jq("$tb")

      sendKeys(tb.toWidget(), "abc" + Keys.TAB)
      waitResponse()
      blur(tb)
      sleep(500)
      var errorPopup = jq(".z-errorbox")
      verifyEquals("", msg.toWidget().get("value"))
      verifyEquals(1, errorPopup.length())

      tb.toElement().set("value", "")
      sendKeys(tb.toWidget(), "Lin" + Keys.TAB)
      waitResponse()
      blur(tb)
      sleep(500)
      verifyEquals("Lin", msg.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

    })
  }
}


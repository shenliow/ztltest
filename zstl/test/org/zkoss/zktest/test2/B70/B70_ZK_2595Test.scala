package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2595.zul")
class B70_ZK_2595Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2595.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Jan 23, 2015 10:08:55 AM, Created by hanhsu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<style>
	.blue {
		border: solid 1px blue;
	}
	.red {
		border: solid 1px red;
	}
	.green {
		border: solid 1px green;
	}
	.black {
		border: solid 1px black;
	}
	</style>
	Please click the button "add newChild" and the size fo black area inside blue area should be up to date
	<hlayout id="container1" width="1800px">
		<div hflex="1">
			<div hflex="1" class="blue">
				<div class="black" hflex="1">
				blue
				</div>
			</div>
		</div>
		<div class="red" hflex="1">
		red
		</div>
		<div class="green" hflex="1">
		green
		</div>
	</hlayout>
	<separator />
	<hbox id="container2" width="1800px">
		<div hflex="1">
			<div hflex="1" class="blue">
				<div class="black" hflex="1">
				blue
				</div>
			</div>
		</div>
		<div class="red" hflex="1">
		red
		</div>
		<div class="green" hflex="1">
		green
		</div>
	</hbox>
	<separator />
	<vlayout id="container3" height="300px">
		<div vflex="1">
			<div vflex="1" class="blue">
				<div class="black" vflex="1">
				blue
				</div>
			</div>
		</div>
		<div class="red" vflex="1">
		red
		</div>
		<div class="green" vflex="1">
		green
		</div>
	</vlayout>
	<separator />
	<vbox id="container4" height="300px">
		<div vflex="1">
			<div vflex="1" class="blue">
				<div class="black" vflex="1">
				blue
				</div>
			</div>
		</div>
		<div class="red" vflex="1">
		red
		</div>
		<div class="green" vflex="1">
		green
		</div>
	</vbox>
	<separator />
	<button label="add newChild">
		<attribute name="onClick">
		container1.appendChild(container1.getLastChild().clone());
		container2.appendChild(container2.getLastChild().clone());
		container3.appendChild(container3.getLastChild().clone());
		container4.appendChild(container4.getLastChild().clone());
		</attribute>
	</button>
</zk>

    
"""  
  runZTL(zscript,
    () => {
      var hlayout = jq(".z-hlayout");
      var hChildrenSize = hlayout.children().eval("size()");
      var hChildWidth = hlayout.width().toInt / hChildrenSize.toInt;
      var it = hlayout.children().iterator();
      while (it.hasNext()) {
        var t = it.next();
        verifyTrue(t.css("width") == hChildWidth + "px");
      }
      
      var hbox = jq(".z-hbox").toWidget();
      var hboxChild = hbox.firstChild();
      var hboxChildWidth = jq(".z-hbox").width().toInt / hbox.nChildren().toInt;
      for (i <- 0 to hbox.nChildren() - 1) {
        var s = "td[id=\"" + hboxChild.uuid() + "-chdex" + "\"]";
        
        verifyTrue(Math.abs(hboxChildWidth - jq(s).width()) < 10);
        hboxChild = hboxChild.nextSibling();
      }
      
      var vlayout = jq(".z-vlayout");
      var vChildrenSize = vlayout.children().eval("size()");
      var vChildWidth = vlayout.height().toInt / vChildrenSize.toInt;
      it = vlayout.children().iterator();
      while (it.hasNext()) {
        var t = it.next();
        verifyTrue(t.css("height") == vChildWidth + "px");
      }
      
      var vbox = jq(".z-vbox").toWidget();
      var vboxChild = vbox.firstChild();
      var vboxChildHeight = jq(".z-vbox").height().toInt / vbox.nChildren().toInt;
      for (i <- 0 to vbox.nChildren() - 1) {
        var s = "tr[id=\"" + vboxChild.uuid() + "-chdex" + "\"]";
        verifyTrue(Math.abs(vboxChildHeight - jq(s).height()) < 10);
        vboxChild = vboxChild.nextSibling();
      }
      
      click(jq("@button"));
      waitResponse();
      
      hlayout = jq(".z-hlayout");
      hChildrenSize = hlayout.children().eval("size()");
      hChildWidth = hlayout.width().toInt / hChildrenSize.toInt;
      it = hlayout.children().iterator();
      while (it.hasNext()) {
        var t = it.next();
        verifyTrue(t.css("width") == hChildWidth + "px");
      }
      
      hbox = jq(".z-hbox").toWidget();
      hboxChild = hbox.firstChild();
      hboxChildWidth = jq(".z-hbox").width().toInt / hbox.nChildren().toInt;
      for (i <- 0 to hbox.nChildren() - 1) {
        var s = "td[id=\"" + hboxChild.uuid() + "-chdex" + "\"]";
        
        verifyTrue(Math.abs(hboxChildWidth - jq(s).width()) < 10);
        hboxChild = hboxChild.nextSibling();
      }
      
      vlayout = jq(".z-vlayout");
      vChildrenSize = vlayout.children().eval("size()");
      vChildWidth = vlayout.height().toInt / vChildrenSize.toInt;
      it = vlayout.children().iterator();
      while (it.hasNext()) {
        var t = it.next();
        verifyTrue(t.css("height") == vChildWidth + "px");
      }
      
      vbox = jq(".z-vbox").toWidget();
      vboxChild = vbox.firstChild();
      vboxChildHeight = jq(".z-vbox").height().toInt / vbox.nChildren().toInt;
      for (i <- 0 to vbox.nChildren() - 1) {
        var s = "tr[id=\"" + vboxChild.uuid() + "-chdex" + "\"]";
        verifyTrue(Math.abs(vboxChildHeight - jq(s).height()) < 10);
        vboxChild = vboxChild.nextSibling();
      }
    })
    
  }
}
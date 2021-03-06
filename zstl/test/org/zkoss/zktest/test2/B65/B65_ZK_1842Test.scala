package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1842.zul")
class B65_ZK_1842Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1842.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jul 15, 2013 12:12:38 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->

<window>

	<zscript><![CDATA[  
        public void populateAndOpen(){
        	Listbox lb = (Listbox) win.getFellow("lb");
        	boolean addAll = lb.getItemCount() == 0;
        	lb.items.clear();
        
			lb.appendChild(new Listitem("a"));
			lb.appendChild(new Listitem("l"));
			
			if(addAll) {
				lb.appendChild(new Listitem("c"));
				lb.appendChild(new Listitem("n"));			
				lb.appendChild(new Listitem("f"));
				lb.appendChild(new Listitem("g"));
				lb.appendChild(new Listitem("b"));
				lb.appendChild(new Listitem("h"));
				lb.appendChild(new Listitem("d"));
				lb.appendChild(new Listitem("i"));
				lb.appendChild(new Listitem("e"));			
				lb.appendChild(new Listitem("k"));			
				lb.appendChild(new Listitem("m"));			
				lb.appendChild(new Listitem("o"));
				lb.appendChild(new Listitem("j"));
			}
			
			Listheader lh = (Listheader) lb.getFellow("header");
			lh.setSortDirection("natural");
			
			// THIS CAUSES THE TROUBLE
			lh.sort(true);
            
            win.setVisible(true);
        }
    ]]>
	</zscript>

	<vlayout>
		<label value="1. Click the button to open the window" />
		<label value="2. Scroll to last item and select it " />
		<label value="3. Click the close me button " />
		<label
			value="4. Click the button to open the window again. You should see 'l' and 'a' item only." />
		<separator />
		<!-- <label
			value="It seems to be the call to sort for the listbox that causes the problem." /> -->

		<button label="Open the window containing the listbox" onClick="populateAndOpen();" />

	</vlayout>

	<window id="win" border="normal" title="Listboxwin" width="200px"
		height="200px" position="center" mode="overlapped" visible="false">
		<menubar>
			<menuitem label="Close me" onClick="win.setVisible(false);" />
		</menubar>
		<div width="100%" vflex="1">
			<listbox id="lb" multiple="true" checkmark="true" vflex="1">
				<listhead>
					<listheader id="header" label="Test" sort="auto" />
				</listhead>
			</listbox>
		</div>
	</window>

</window>
"""  
  runZTL(zscript,
    () => {
      val open = jq(".z-button:contains(Open)")
      click(open)
      waitResponse()
      
      verScroll(jq(".z-listbox"), 1)
      click(jq(".z-listitem:contains(i)"))
      waitResponse()
      
      click(jq(".z-menuitem").toWidget().$n("a"))
      waitResponse()
      
      click(open)
      waitResponse()
      
      verifyTrue("You should see 'l' and 'a' item only.", 
          jq(".z-listitem").length() == 2 && jq(".z-listitem:contains(a)").exists 
          && jq(".z-listitem:contains(l)").exists)
    })
    
  }
}
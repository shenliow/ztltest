package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Listbox_Header_Auxhead_Auxhead_Listhead_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<listbox fixedLayout="true" width="900px">
	<auxhead>
		<auxheader label="A+B" colspan="2" />
		<auxheader label="C" />
	</auxhead>
	<auxhead>
		<auxheader label="C"  />
		<auxheader label="D + E" colspan="2"/>
	</auxhead>
	<listhead id="cs">
		<listheader label="Align Left" align="left"/>
		<listheader label="Align Center" align="center"/>
		<listheader label="Align Right" align="right"/>
	</listhead>
	<listitem>
		<listcell label="AA01" />
		<listcell label="BB01" />
		<listcell label="CC01" />
	</listitem>
	<listfoot>
		<listfooter label="footer 1" />
		<listfooter label="footer 2" />
		<listfooter label="footer 3" />
	</listfoot>
</listbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}

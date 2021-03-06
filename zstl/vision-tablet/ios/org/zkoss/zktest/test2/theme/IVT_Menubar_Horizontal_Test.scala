package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Menubar_Horizontal_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<menubar id="menubar" width="100%">
		<menu id="project" label="Project" 
			image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
			<menupopup>
				<menuitem
					image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png"
					label="New" onClick="alert(self.label)" />
				<menuitem
					image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png"
					label="Open" onClick="alert(self.label)" />
				<menuitem
					image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png"
					label="Save" onClick="alert(self.label)" />
				<menuseparator />
				<menuitem label="Exit"
					image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png"
					onClick="alert(self.label)" />
			</menupopup>
		</menu>
		<menuseparator />
		<menu label="Help"
			image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
			<menupopup>
				<menuitem label="Index"
					onClick="alert(self.label)" />
				<menu label="About">
					<menupopup>
						<menuitem label="About ZK"
							onClick="alert(self.label)" />
						<menuitem label="About Potix"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
			</menupopup>
		</menu>
		<menu
			image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
			<menupopup>
				<menuitem label="Index"
					onClick="alert(self.label)" />
			</menupopup>
		</menu>
		<menuitem label="Menuitem" onClick="alert(self.label)" />
		<menuitem image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png" disabled="true" label="Menuitem" onClick="alert(self.label)" />
	</menubar>
	
	<zscript>
	project.open();
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}

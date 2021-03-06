package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-2079.zul")
class F70_ZK_2079Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>
		<div>should see paging in each mesh component</div>
	</div>
	<hlayout>
		<window title="1 Page" border="normal" width="600px">
			<div>grid</div>
			<grid id="gd" mold="paging" pageSize="2">
				<custom-attributes
					org.zkoss.zul.grid.autohidePaging="false" />
				<columns menupopup="auto">
					<column label="Author" />
					<column label="Title" />
				</columns>
				<rows id="rows">
					<row>
						<label value="Philip Hensher" />
						<label value="The Northern Clemency" />
					</row>
					<row>
						<label value="Philip Hensher" />
						<label value="The Fit" />
					</row>
				</rows>
			</grid>

			<div>listbox</div>
			<listbox id="lb" mold="paging" pageSize="2">
				<custom-attributes
					org.zkoss.zul.listbox.autohidePaging="false" />
				<listhead>
					<listheader label="Author" />
					<listheader label="Title" />
				</listhead>
				<listitem>
					<listcell>
						<label value="Philip Hensher" />
					</listcell>
					<listcell>
						<label value="The Northern Clemency" />
					</listcell>
				</listitem>
				<listitem>
					<listcell>
						<label value="Philip Hensher" />
					</listcell>
					<listcell>
						<label value="The Fit" />
					</listcell>
				</listitem>
			</listbox>

			<div>tree</div>
			<tree id="tr" mold="paging" pageSize="2">
				<custom-attributes
					org.zkoss.zul.tree.autohidePaging="false" />
				<treecols>
					<treecol label="Author" />
					<treecol label="Title" />
				</treecols>
				<treechildren id="tc">
					<treeitem>
						<treerow>
							<treecell>
								<label value="Philip Hensher" />
							</treecell>
							<treecell>
								<label value="The Northern Clemency" />
							</treecell>
						</treerow>
					</treeitem>
					<treeitem>
						<treerow>
							<treecell>
								<label value="Philip Hensher" />
							</treecell>
							<treecell>
								<label value="The Fit" />
							</treecell>
						</treerow>
					</treeitem>
				</treechildren>
			</tree>
		</window>
		<window title="empty" border="normal" width="600px">
			<div>grid</div>
			<grid id="gd1" mold="paging" pageSize="5"
				emptyMessage="This Grid is empty.">
				<custom-attributes
					org.zkoss.zul.grid.autohidePaging="false" />
				<columns menupopup="auto">
					<column label="Col" />
				</columns>
			</grid>

			<div>listbox</div>
			<listbox id="lb1" mold="paging" pageSize="5"
				emptyMessage="This Listbox is empty.">
				<custom-attributes
					org.zkoss.zul.listbox.autohidePaging="false" />
				<listhead>
					<listheader label="Col" />
				</listhead>
			</listbox>

			<div>tree</div>
			<tree id="tr1" mold="paging" pageSize="5">
				<custom-attributes
					org.zkoss.zul.tree.autohidePaging="false" />
				<treecols>
					<treecol label="Col" />
				</treecols>
			</tree>
		</window>
	</hlayout>
</zk>
"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}
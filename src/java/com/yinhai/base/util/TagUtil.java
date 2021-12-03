package com.yinhai.base.util;

import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagAdapter;

public class TagUtil {

	public static JspTag getTa3ParentTag(JspTag tag) {
		if (tag instanceof SimpleTagSupport) {
			return tag;
		}
		if (tag instanceof TagAdapter) {
			return ((TagAdapter) tag).getAdaptee();
		}
		if (tag instanceof Tag) {
			JspTag jspTag = ((Tag) tag).getParent();
			if (jspTag != null)
				return getTa3ParentTag(jspTag);
			else
				return tag;
		} else {
			return tag;
		}
	}
}

package com.wengs.web.view.prepare;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class PagePrepare implements ViewPreparer {

	@Override
	public void execute(Request context, AttributeContext attributeContext) {
		String title = (String) context.getContext(Request.REQUEST_SCOPE).get(
				"title");
		attributeContext.putAttribute("title", new Attribute(title));
	}

}

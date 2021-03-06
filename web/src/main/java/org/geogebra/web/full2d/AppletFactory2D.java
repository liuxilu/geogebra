package org.geogebra.web.full2d;

import org.geogebra.web.full.gui.applet.AppletFactory;
import org.geogebra.web.full.gui.applet.GeoGebraFrameFull;
import org.geogebra.web.full.main.AppWFull;
import org.geogebra.web.full.main.GDevice;
import org.geogebra.web.html5.gui.laf.GLookAndFeelI;
import org.geogebra.web.html5.main.AppW;
import org.geogebra.web.html5.util.ArticleElementInterface;
import org.geogebra.web.simple.Stub3DFragment;

/**
 * Applet factory for 2D compilation
 */
public class AppletFactory2D implements AppletFactory {

	/**
	 * Load 3D stub when created
	 */
	public AppletFactory2D() {
		Stub3DFragment.load();
	}

	@Override
	public AppW getApplet(ArticleElementInterface ae, GeoGebraFrameFull gf,
			GLookAndFeelI laf, GDevice device) {
		return new AppWFull(ae, 2, laf, device, gf);
	}

}

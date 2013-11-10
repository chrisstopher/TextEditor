package texteditor;

import javax.swing.text.Style;
import javax.swing.text.StyleConstants;


//do not work probably because it needs to keep up with if it actually is already bold or italics or etc...
//StyleConstants.setBold(style, !StyleConstants.isBold(style));
//StyleConstants.setItalic(style, !StyleConstants.isItalic(style));
//StyleConstants.setUnderline(style, !StyleConstants.isUnderline(style));
//StyleConstants.setStrikeThrough(style, !StyleConstants.isStrikeThrough(style));

public interface StyleChanger {
	void change(Style style);
}

class TextToBold implements StyleChanger {
	public void change(Style style) {
		StyleConstants.setBold(style, true);
	}
}

class TextToItalics implements StyleChanger {
	public void change(Style style) {
		StyleConstants.setItalic(style, true);
	}
}

class TextToUnderline implements StyleChanger {
	public void change(Style style) {
		StyleConstants.setUnderline(style, true);
	}
}

class TextToStrikeThrough implements StyleChanger {
	public void change(Style style) {
		StyleConstants.setStrikeThrough(style, true);
	}
}
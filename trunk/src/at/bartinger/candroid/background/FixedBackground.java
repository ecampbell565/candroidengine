/**
 *  Copyright 2010 Bartl Dominic

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package at.bartinger.candroid.background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import at.bartinger.candroid.texture.Texture;

public class FixedBackground extends Background{
	
	private Bitmap mBackground;
	
	public FixedBackground(Texture tex) {
		mBackground = tex.tex;
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(mBackground, (int)x, (int)y, null);
		super.draw(canvas);
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}

}

/*
 * Copyright (c) 2010-2011, Martin Pernollet
 * All rights reserved. 
 *
 * Redistribution in binary form, with or without modification, is permitted.
 * Edition of source files is allowed.
 * Redistribution of original or modified source files is FORBIDDEN.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jzy3d.demos.scatter;

import org.jzy3d.chart.Chart;
import org.jzy3d.colors.Color;
import org.jzy3d.demos.AbstractDemo;
import org.jzy3d.demos.DemoLauncher;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;


public class ScatterDemo extends AbstractDemo{
	public static void main(String[] args) throws Exception {
		DemoLauncher.openDemo(new ScatterDemo());
	}
	
	public ScatterDemo(){
	}
	
	public void init(){
        int size = 500000;
        float x;
        float y;
        float z;
        float a;
        
        Coord3d[] points = new Coord3d[size];
        Color[]   colors = new Color[size];
        
        for(int i=0; i<size; i++){
            x = (float)Math.random() - 0.5f;
            y = (float)Math.random() - 0.5f;
            z = (float)Math.random() - 0.5f;
            points[i] = new Coord3d(x, y, z);
            a = 0.25f;
            colors[i] = new Color(x, y, z, a);
        }
        
        Scatter scatter = new Scatter(points, colors);
        chart = new Chart(Quality.Advanced, getCanvasType());
        chart.getScene().add(scatter);
    }
}

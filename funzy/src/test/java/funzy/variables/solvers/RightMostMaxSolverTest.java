// The MIT License - Copyright (c) 2007 Universitetet i Oslo

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE. 
package funzy.variables.solvers;

import static com.google.common.collect.Lists.immutableList;
import static funzy.variables.memberships.PointMembership.newPoint;
import static funzy.variables.solvers.Solvers.RMM;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import funzy.variables.memberships.PointMembership;

/**
 * Test of the right most max (RMM) solver.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public class RightMostMaxSolverTest {
    private PointMembership a, b, c, d;

    @Before
    public void setup() {
        a = newPoint(0, 0);
        b = newPoint(1, 1);
        c = newPoint(2, 1);
        d = newPoint(3, 0);
    }

    @Test
    public void pointRMM() {
        assertEquals(a, RMM.solve(immutableList(a)));
    }

    @Test
    public void increasingLineRMM() {
        assertEquals(b, RMM.solve(immutableList(a, b)));
    }

    @Test
    public void horizontalLineRMM() {
        assertEquals(c, RMM.solve(immutableList(b, c)));
    }

    @Test
    public void decreasingLineRMM() {
        assertEquals(c, RMM.solve(immutableList(c, d)));
    }

    @Test
    public void triangleRMM() {
        assertEquals(b, RMM.solve(immutableList(a, b, d)));
    }

    @Test
    public void trapezoidRMM() {
        assertEquals(c, RMM.solve(immutableList(a, b, c)));
    }
}

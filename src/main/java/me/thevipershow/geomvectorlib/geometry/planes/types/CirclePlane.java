/*
 *
 *  * Software licensed by TheViperShow
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *  * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 *  * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 *  * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  * OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package me.thevipershow.geomvectorlib.geometry.planes.types;

import java.util.HashSet;
import java.util.Set;
import me.thevipershow.geomvectorlib.geometry.planes.RegularPlaneShape;
import me.thevipershow.geomvectorlib.pairs.DoublePair;

public class CirclePlane extends RegularPlaneShape {
    public CirclePlane(double radius, DoublePair center) {
        super(1, radius, center);
    }

    public CirclePlane(double radius, double x1, double y1) {
        super(1, radius, x1, y1);
    }

    private Set<DoublePair> getCircleVertexes(double distribution, double degrees) {
        final Set<DoublePair> doublePairSet = new HashSet<>();
        for (double i = 0d; i < Math.toRadians(degrees); i += Math.toRadians(distribution)) {
            doublePairSet.add(new DoublePair(
                    (radius * Math.sin(i)) + center.getFirst(),
                    (radius * Math.cos(i)) + center.getSecond()
            ));
        }
        return doublePairSet;
    }

    @Override
    public Set<DoublePair> calculateVertexes(double distribution) {
        return getCircleVertexes(distribution, 360d);
    }

    public Set<DoublePair> calculateVertexes(double distribution, double degrees) {
        return getCircleVertexes(distribution, degrees);
    }

    /**
     * Calculate the surface of the current circle
     *
     * @return the surface of this circle from the radius
     * {@see <a href="https://en.wikipedia.org/wiki/Circle#Area_enclosed">Circle surface</a>}
     */
    @Override
    public double calculateSurface() {
        return (Math.PI * Math.pow(radius, 2d));
    }

    /**
     * Calculate the length of the circumference of the current circle
     *
     * @return the length of the circumference from the radius
     * {@see <a href="https://en.wikipedia.org/wiki/Circle#Length_of_circumference">Circle circumference</a>}
     */
    public double calculateCircumference() {
        return (Math.PI * (radius * 2));
    }
}

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

package me.thevipershow.geomvectorlib.geometry.planes.types.regular;

import java.util.ArrayList;
import java.util.List;
import me.thevipershow.geomvectorlib.geometry.planes.CircularPlaneShape;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import org.jetbrains.annotations.NotNull;

public class CirclePlane extends CircularPlaneShape {

    @NotNull
    public CirclePlane(final double radius, @NotNull final DoublePair center) {
        super(radius, center);
    }

    @NotNull
    public CirclePlane(final double radius, final double x, final double y) {
        super(radius, x, y);
    }

    @NotNull
    private List<DoublePair> getCircleVertexes(final double delta, final double degrees) {
        final List<DoublePair> doublePairSet = new ArrayList<>();
        for (double i = 0d; i < Math.toRadians(degrees); i += Math.toRadians(delta)) {
            doublePairSet.add(new DoublePair(
                    (super.radius * Math.sin(i)) + super.center.getFirst(),
                    (super.radius * Math.cos(i)) + super.center.getSecond()
            ));
        }
        return doublePairSet;
    }

    @NotNull
    @Override
    public List<DoublePair> calculateSpacedLines(final double delta) {
        return getCircleVertexes(delta, 360d);
    }

    @NotNull
    public List<DoublePair> calculateSpacedLines(final double delta, final double degrees) {
        return getCircleVertexes(delta, degrees);
    }

    /**
     * Calculate the surface of the current circle
     *
     * @return the surface of this circle from the radius
     * {@see <a href="https://en.wikipedia.org/wiki/Circle#Area_enclosed">Circle surface</a>}
     */
    @Override
    public double getSurface() {
        return (Math.PI * Math.pow(super.radius, 2d));
    }

    /**
     * Calculate the length of the circumference of the current circle
     *
     * @return the length of the circumference from the radius
     * {@see <a href="https://en.wikipedia.org/wiki/Circle#Length_of_circumference">Circle circumference</a>}
     */
    @Override
    public double getPerimeter() {
        return (Math.PI * (super.radius * 2));
    }
}

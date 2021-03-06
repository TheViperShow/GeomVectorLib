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
import me.thevipershow.geomvectorlib.geometry.planes.BidimensionalUtils;
import me.thevipershow.geomvectorlib.geometry.planes.RegularPlaneShape;
import me.thevipershow.geomvectorlib.pairs.DoublePair;
import org.jetbrains.annotations.NotNull;

public class SquarePlane extends RegularPlaneShape {
    @NotNull
    public SquarePlane(final double radius, @NotNull final DoublePair center) {
        super(4, radius, center);
    }

    @NotNull
    public SquarePlane(final double radius, final double x1, final double y1) {
        super(4, radius, x1, y1);
    }

    @NotNull
    @Override
    public List<DoublePair> calculateVertexes() {
        final List<DoublePair> vertexes = new ArrayList<>();
        vertexes.add(super.center.sum(super.apothem, super.apothem));
        vertexes.add(super.center.sum(super.apothem, -super.apothem));
        vertexes.add(super.center.sum(-super.apothem, super.apothem));
        vertexes.add(super.center.sum(-super.apothem, -super.apothem));
        return vertexes;
    }

    @Override
    public @NotNull List<DoublePair> calculateSpacedLines(double delta) {
        final List<DoublePair> vertexes = calculateVertexes();
        final List<DoublePair> spacedLines = new ArrayList<>();
        spacedLines.addAll(BidimensionalUtils.joinTwoSpacePoints(vertexes.get(0), vertexes.get(1), delta));
        spacedLines.addAll(BidimensionalUtils.joinTwoSpacePoints(vertexes.get(1), vertexes.get(2), delta));
        spacedLines.addAll(BidimensionalUtils.joinTwoSpacePoints(vertexes.get(2), vertexes.get(3), delta));
        spacedLines.addAll(BidimensionalUtils.joinTwoSpacePoints(vertexes.get(3), vertexes.get(0), delta));
        return spacedLines;
    }

    @Override
    public double getPerimeter() {
        return super.apothem * 8d;
    }

    @Override
    public double getSurface() {
        return Math.pow(super.apothem * 2d, 2d);
    }
}

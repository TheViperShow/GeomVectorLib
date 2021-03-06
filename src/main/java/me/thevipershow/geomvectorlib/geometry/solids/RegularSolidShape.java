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

package me.thevipershow.geomvectorlib.geometry.solids;

import me.thevipershow.geomvectorlib.geometry.common.SolidCalculator;
import me.thevipershow.geomvectorlib.geometry.common.SpacedLinesCalculator;
import me.thevipershow.geomvectorlib.geometry.common.VertexesCalculator;
import me.thevipershow.geomvectorlib.triples.DoubleTriple;
import org.jetbrains.annotations.NotNull;

public abstract class RegularSolidShape implements VertexesCalculator<DoubleTriple>, SpacedLinesCalculator<DoubleTriple>, SolidCalculator {
    protected final @NotNull DoubleTriple center;
    protected final double apothem;

    @NotNull
    public RegularSolidShape(@NotNull final DoubleTriple center, final double apothem) {
        this.center = center;
        this.apothem = apothem;
    }
}

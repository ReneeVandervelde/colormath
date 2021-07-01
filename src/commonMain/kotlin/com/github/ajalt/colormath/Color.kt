package com.github.ajalt.colormath

/**
 * A color that can be converted to other representations.
 *
 * The conversion functions can return the object they're called on if it is already in the
 * correct format.
 *
 * Note that there is not a direct conversion between every pair of representations. In those cases,
 * the values may be converted through one or more intermediate representations. This may cause a
 * loss of precision.
 *
 * All colors have an [alpha] value, which is the opacity of the color as a fraction between 0 and 1. If a model doesn't
 * support an alpha channel, the value 1 (fully opaque) is used.
 */
interface Color {
    /** The opacity of this color, in the range `[0, 1]`. */
    val alpha: Float

    /** The model describing this color */
    val model: ColorModel<*>

    /** Convert this color to Red-Green-Blue (using sRGB color space) */
    fun toRGB(): RGB

    /** Convert this color to Hue-Saturation-Luminosity */
    fun toHSL(): HSL = toRGB().toHSL()

    /** Convert this color to Hue-Saturation-Value */
    fun toHSV(): HSV = toRGB().toHSV()

    /** Convert this color to a 16-color ANSI code */
    fun toAnsi16(): Ansi16 = toRGB().toAnsi16()

    /** Convert this color to a 256-color ANSI code */
    fun toAnsi256(): Ansi256 = toRGB().toAnsi256()

    /** Convert this color to Cyan-Magenta-Yellow-Key */
    fun toCMYK(): CMYK = toRGB().toCMYK()

    /** Convert this color to CIE XYZ */
    fun toXYZ(): XYZ = toRGB().toXYZ()

    /** Convert this color to CIE LAB */
    fun toLAB(): LAB = toXYZ().toLAB()

    /** Convert this color to CIE LCh(ab) */
    fun toLCH(): LCH = toLAB().toLCH()

    /** Convert this color to CIE LUV */
    fun toLUV(): LUV = toXYZ().toLUV()

    /** Convert this color to CIE LCh(uv) */
    fun toHCL(): HCL = toLUV().toHCL()

    /** Convert this color to HWB */
    fun toHWB(): HWB = toRGB().toHWB()

    /** Convert this color to Linear sRGB */
    fun toLinearRGB(): LinearRGB = toRGB().toLinearRGB()

    /** Convert this color to Oklab */
    fun toOklab(): Oklab = toXYZ().toOklab()

    /** Convert this color to Oklch*/
    fun toOklch(): Oklch = toOklab().toOklch()

    /** Create a [FloatArray] containing all components of this color, with the [alpha] as the last component */
    fun toArray(): FloatArray

    companion object // enables extensions on the interface
}

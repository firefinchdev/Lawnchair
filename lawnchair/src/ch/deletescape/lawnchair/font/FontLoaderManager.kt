/*
 *     This file is part of Lawnchair Launcher.
 *
 *     Lawnchair Launcher is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lawnchair Launcher is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lawnchair Launcher.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.deletescape.lawnchair.font

import android.content.Context
import ch.deletescape.lawnchair.ensureOnMainThread
import ch.deletescape.lawnchair.useApplicationContext
import ch.deletescape.lawnchair.util.SingletonHolder

class FontLoaderManager(private val context: Context) {

    private val fontLoaders = HashMap<String, FontLoader>()

    fun loadFont(fontName: String): FontLoader {
        return fontLoaders.getOrPut(fontName) { FontLoader(context, fontName) }
    }

    companion object : SingletonHolder<FontLoaderManager, Context>(ensureOnMainThread(
            useApplicationContext(::FontLoaderManager)))
}
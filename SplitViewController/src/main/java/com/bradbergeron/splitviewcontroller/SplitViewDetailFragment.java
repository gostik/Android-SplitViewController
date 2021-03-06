/*
 * Copyright (c) 2014 Bradley David Bergeron
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bradbergeron.splitviewcontroller;

import android.app.FragmentTransaction;

public abstract class SplitViewDetailFragment extends SplitViewAbsFragment {

    // ================================================================================
    // Presentation
    // ================================================================================

    protected void pushDetailFragment (final SplitViewDetailFragment detailFragment) {
        pushDetailFragment(detailFragment, getFragmentManager().beginTransaction());
    }

    protected void pushDetailFragment (final SplitViewDetailFragment detailFragment,
                                       final FragmentTransaction transaction) {
        detailFragment.setController(getController());

        transaction.replace(getId(), detailFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // ================================================================================
    // Helpers
    // ================================================================================

    protected void setTitle (final CharSequence title) {
        getController().setDetailViewTitle(title);
    }

    protected void setSubtitle (final CharSequence subtitle) {
        getController().setDetailViewSubtitle(subtitle);
    }

    @Override
    protected int getViewId () {
        return getController().getDetailFragmentContainerId();
    }
}

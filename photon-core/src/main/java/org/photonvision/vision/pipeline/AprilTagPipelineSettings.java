/*
 * Copyright (C) Photon Vision.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.photonvision.vision.pipeline;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonTypeName;

import org.photonvision.vision.calibration.CameraCalibrationCoefficients;

@JsonTypeName("AprilTagPipelineSettings")
public class AprilTagPipelineSettings extends AdvancedPipelineSettings {

    public String tagFamily = "36h11";
    public double decimate = 1.0;
    public double blur = 0.5;
    public int threads = 1;
    public boolean debug = false;
    public boolean refineEdges = true;
    // 3d settings


    public AprilTagPipelineSettings() {
        super();
        pipelineType = PipelineType.AprilTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AprilTagPipelineSettings that = (AprilTagPipelineSettings) o;
        return Objects.equals(tagFamily, that.tagFamily)
            && Double.compare(decimate, that.decimate) == 0
            && Double.compare(blur, that.blur) == 0
            && threads == that.threads
            && debug == that.debug
            && refineEdges == that.refineEdges;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                tagFamily,
                decimate,
                blur,
                threads,
                debug,
                refineEdges);
    }
}

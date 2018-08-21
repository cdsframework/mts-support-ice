/**
 * The MTS support ice project contains client related utilities, data transfer objects and remote EJB interfaces for communication with the CDS Framework Middle Tier Service.
 *
 * Copyright (C) 2016 New York City Department of Health and Mental Hygiene, Bureau of Immunization
 * Contributions by HLN Consulting, LLC
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version. You should have received a copy of the GNU Lesser
 * General Public License along with this program. If not, see <http://www.gnu.org/licenses/> for more
 * details.
 *
 * The above-named contributors (HLN Consulting, LLC) are also licensed by the New York City
 * Department of Health and Mental Hygiene, Bureau of Immunization to have (without restriction,
 * limitation, and warranty) complete irrevocable access and rights to this project.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; THE
 *
 * SOFTWARE IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING,
 * BUT NOT LIMITED TO, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE COPYRIGHT HOLDERS, IF ANY, OR DEVELOPERS BE LIABLE FOR
 * ANY CLAIM, DAMAGES, OR OTHER LIABILITY OF ANY KIND, ARISING FROM, OUT OF, OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information about this software, see https://www.hln.com/services/open-source/ or send
 * correspondence to ice@hln.com.
 */
package org.cdsframework.dto;

import javax.validation.constraints.NotNull;
import org.cdsframework.annotation.Column;
import org.cdsframework.annotation.Entity;
import org.cdsframework.annotation.GeneratedValue;
import org.cdsframework.annotation.Id;
import org.cdsframework.annotation.JndiReference;
import org.cdsframework.annotation.Permission;
import org.cdsframework.annotation.ReferenceDTO;
import org.cdsframework.annotation.Table;
import org.cdsframework.aspect.annotations.PropertyListener;
import org.cdsframework.base.BaseDTO;
import org.cdsframework.enumeration.GenerationSource;

/**
 *
 * @author HLN Consulting, LLC
 */
@Entity
@Table(databaseId = "ICE", name = "ice_test_recommendation")
@JndiReference(root = "mts-ejb-ice")
@Permission(name = "ICE Test Recommendation")
public class IceTestRecommendationDTO extends BaseDTO {

    public interface ByProposalId {
    }
    private static final long serialVersionUID = -8150625790045629197L;
    @GeneratedValue(source = GenerationSource.AUTO)
    @Id
    private String recommendationId;
    @GeneratedValue(source = GenerationSource.FOREIGN_CONSTRAINT, sourceClass = IceTestProposalDTO.class)
    private String proposalId;
    @NotNull
    @ReferenceDTO
    @Column(name = "rec_interpret_id")
    private CdsCodeDTO recommendationInterpretation;

    /**
     * Get the value of proposalId
     *
     * @return the value of proposalId
     */
    public String getProposalId() {
        return proposalId;
    }

    /**
     * Set the value of proposalId
     *
     * @param proposalId new value of proposalId
     */
    @PropertyListener
    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    /**
     * Get the value of recommendationId
     *
     * @return the value of recommendationId
     */
    public String getRecommendationId() {
        return recommendationId;
    }

    /**
     * Set the value of recommendationId
     *
     * @param recommendationId new recommendationValue of recommendationId
     */
    @PropertyListener
    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    /**
     * Get the value of recommendationInterpretation
     *
     * @return the value of recommendationInterpretation
     */
    public CdsCodeDTO getRecommendationInterpretation() {
        return recommendationInterpretation;
    }

    /**
     * Set the value of recommendationInterpretation
     *
     * @param recommendationInterpretation new recommendationValue of
     * recommendationInterpretation
     */
    @PropertyListener
    public void setRecommendationInterpretation(CdsCodeDTO recommendationInterpretation) {
        this.recommendationInterpretation = recommendationInterpretation;
    }
}

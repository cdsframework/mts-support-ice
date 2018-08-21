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

import java.util.List;
import org.cdsframework.annotation.Column;
import org.cdsframework.annotation.Entity;
import org.cdsframework.annotation.GeneratedValue;
import org.cdsframework.annotation.Id;
import org.cdsframework.annotation.JndiReference;
import org.cdsframework.annotation.OrderBy;
import org.cdsframework.annotation.OrderByMapEntries;
import org.cdsframework.annotation.OrderByMapEntry;
import org.cdsframework.annotation.ParentChildRelationship;
import org.cdsframework.annotation.ParentChildRelationships;
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
@OrderByMapEntries({
     @OrderByMapEntry(sortFieldKey = "diseaseCdsCodeDTO.displayName", sortFieldValue = "lower(display_name)")
})
@OrderBy(fields = "lower(display_name)")
@Table(databaseId = "ICE", name = "ice_disease", view = "vw_ice_disease")
@JndiReference(root = "mts-ejb-ice")
@Permission(name = "ICE Disease")
@ParentChildRelationships({
    @ParentChildRelationship(childDtoClass = IceDiseaseVersionConceptRelDTO.class, childQueryClass = IceDiseaseVersionConceptRelDTO.ByDiseaseId.class, isAutoRetrieve = false)
})
public class IceDiseaseDTO extends BaseDTO {

    private static final long serialVersionUID = -4192926705404537807L;

    @GeneratedValue(source = GenerationSource.AUTO)
    @Id
    private String diseaseId;
    @Column(name = "code_id")
    @ReferenceDTO(isNotFoundAllowed = false)
    private CdsCodeDTO diseaseCdsCodeDTO;

    /**
     * Get the value of diseaseId
     *
     * @return the value of diseaseId
     */
    public String getDiseaseId() {
        return diseaseId;
    }

    /**
     * Set the value of diseaseId
     *
     * @param diseaseId new value of diseaseId
     */
    @PropertyListener
    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * Get the value of diseaseCdsCodeDTO
     *
     * @return the value of diseaseCdsCodeDTO
     */
    public CdsCodeDTO getDiseaseCdsCodeDTO() {
        return diseaseCdsCodeDTO;
    }

    /**
     * Set the value of diseaseCdsCodeDTO
     *
     * @param diseaseCdsCodeDTO new value of diseaseCdsCodeDTO
     */
    @PropertyListener
    public void setDiseaseCdsCodeDTO(CdsCodeDTO diseaseCdsCodeDTO) {
        this.diseaseCdsCodeDTO = diseaseCdsCodeDTO;
    }

    public List<IceDiseaseVersionConceptRelDTO> getIceDiseaseVersionConceptRelDTOs() {
        return getChildrenDTOs(IceDiseaseVersionConceptRelDTO.ByDiseaseId.class, IceDiseaseVersionConceptRelDTO.class);
    }
}
package kr.kro.moonlightmoist.shopapi.product.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import kr.kro.moonlightmoist.shopapi.product.dto.DetailInfoDTO;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@Table(name = "product_detail_info")
public class DetailInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String capacity;
    private String skinType;
    private String usagePeriod;
    @Column(columnDefinition = "TEXT")
    private String usageMethod;
    @Column(length = 500)
    private String manufacturer;
    private String madeInCountry;
    @Column(columnDefinition = "TEXT")
    private String ingredients;
    private String functionalCertification;
    @Column(columnDefinition = "TEXT")
    private String caution;
    @Column(length = 1000)
    private String qualityGuarantee;
    private String customerServiceNumber;

    public DetailInfoDTO toDTO() {
        return DetailInfoDTO.builder()
                .id(this.id)
                .capacity(this.capacity)
                .skinType(this.skinType)
                .usagePeriod(this.usagePeriod)
                .usageMethod(this.usageMethod)
                .manufacturer(this.manufacturer)
                .madeInCountry(this.madeInCountry)
                .ingredients(this.ingredients)
                .functionalCertification(this.functionalCertification)
                .caution(this.caution)
                .qualityGuarantee(this.qualityGuarantee)
                .customerServiceNumber(this.customerServiceNumber)
                .build();
    }

    public DetailInfo changeDetailInfo(DetailInfoDTO dto) {

        this.setCapacity(dto.getCapacity());
        this.setSkinType(dto.getSkinType());
        this.setUsageMethod(dto.getUsageMethod());
        this.setUsagePeriod(dto.getUsagePeriod());
        this.setManufacturer(dto.getManufacturer());
        this.setMadeInCountry(dto.getMadeInCountry());
        this.setIngredients(dto.getIngredients());
        this.setFunctionalCertification(dto.getFunctionalCertification());
        this.setCaution(dto.getCaution());
        this.setQualityGuarantee(dto.getQualityGuarantee());
        this.setCustomerServiceNumber(dto.getCustomerServiceNumber());

        return this;
    }

}

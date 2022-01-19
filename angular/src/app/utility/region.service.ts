import { Injectable } from "@angular/core";

@Injectable()
export class RegionService {

    private regions: RegionType[] = [
        RegionType.WESTERN_EUROPE,
        RegionType.EASTERN_EUROPE,
        RegionType.CHINA,
        RegionType.SOUTHEAST_ASIA,
        RegionType.NORTH_AMERICA,
        RegionType.SOUTH_AMERICA,
    ];

    public getAllRegions(): RegionType[] {
        return this.regions;
    }

    public getRegionByIndex(index: number): RegionType {
        return this.regions[index];
    }
}

export class RegionType {
    static readonly WESTERN_EUROPE  = new RegionType("WESTERN_EUROPE", 0, "Western Europe", "WEU");
    static readonly EASTERN_EUROPE = new RegionType("EASTERN_EUROPE", 1, "Eastern Europe", "EEU");
    static readonly CHINA  = new RegionType("CHINA", 2, "China", "CN");
    static readonly SOUTHEAST_ASIA  = new RegionType("SOUTHEAST_ASIA", 3, "SE Asia", "SEA");
    static readonly NORTH_AMERICA = new RegionType("NORTH_AMERICA", 4, "North America", "NA");
    static readonly SOUTH_AMERICA  = new RegionType("SOUTH_AMERICA", 5, "South America", "SA");

    private constructor(private readonly key: string,
        public readonly index: number,
        public readonly value: string,
        public readonly abbreviation: string) {
    }

    public toString(): string {
        return this.key;
    }
}
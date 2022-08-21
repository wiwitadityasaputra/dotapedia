export interface PlayerCountry {
    country: string;
    totalPlayer: number;
}

export interface Player {
    country: string;
    dateOfBirth: number;
    fullName: string;
    id: number;
    nickName: string;
    roles: string;
    totalEarnings: string;
}

export interface PlayerDetailResponse {
    country: string;
    dateOfBirth: number;
    fullName: string;
    id: number;
    nickName: string;
    roles: string;
    totalEarnings: string;
    playerScreenshots: PlayerScreenshotResponse[];
}

export interface PlayerScreenshotResponse {
    id: number;
    imageName: string;
}
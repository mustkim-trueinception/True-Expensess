package com.example.true_expensess.ui.customTheme

import androidx.compose.ui.graphics.Color

interface TextColors {
    val Active: Color
    val Inactive: Color
    val Disabled: Color
}



interface ActionColors {
    val Main: Color
    val Hover: Color
    val Pressed: Color
    val Focused: Color
    val Disabled: Color

    val TextMain: Color
    val TextHover: Color
    val TextPressed: Color
    val TextFocused: Color
    val TextDisabled: Color
}

interface GhostedColors {
    val Main: Color
    val TextMain: Color
}

interface SeverityActionColors : ActionColors {
    val Ghosted: GhostedColors
}

interface ActionSeverityColors {
    val Safe: SeverityActionColors
    val Warning: SeverityActionColors
    val Medium: SeverityActionColors
    val Danger: SeverityActionColors
    val Critical: SeverityActionColors
}

interface ThemeColors {
    val Surface50: Color
    val Surface100: Color
    val Surface200: Color
    val Surface300: Color
    val Surface400: Color
    val Surface500: Color
    val Surface600: Color
    val Surface700: Color
    val Surface800: Color
    val Surface900: Color

    val Shade50: Color
    val Shade100: Color
    val Shade200: Color
    val Shade300: Color
    val Shade400: Color
    val Shade500: Color
    val Shade600: Color
    val Shade700: Color
    val Shade800: Color
    val Shade900: Color

    val BorderPrimary: Color
    val BorderSecondary: Color
    val BorderInfo: Color
    val BorderSuccess: Color
    val BorderWarning: Color
    val BorderError: Color
    val BorderDivider: Color
    val BorderDisabled: Color

    val Text: TextColors

    val Primary: ActionColors
    val Secondary: ActionColors
    val Info: ActionColors
    val Success: ActionColors
    val Warning: ActionColors
    val Error: ActionColors

    val Severity: ActionSeverityColors
}

object BaseColors {
    /* Dark Colors */
    val Dark900: Color = Color(0xFF121212)
    val Dark800: Color = Color(0xFF161616)
    val Dark700: Color = Color(0xFF1E1E1E)
    val Dark600: Color = Color(0xFF212121)
    val Dark500: Color = Color(0xFF252525)
    val Dark400: Color = Color(0xFF272727)
    val Dark300: Color = Color(0xFF2C2C2C)
    val Dark200: Color = Color(0xFF333333)
    val Dark100: Color = Color(0xFF363636)
    val Dark50: Color = Color(0xFF434343)

    /* Light Colors */
    val Light900: Color = Color(0xFFA1A4A8)
    val Light800: Color = Color(0xFFAEB2B7)
    val Light700: Color = Color(0xFFBEC2C7)
    val Light600: Color = Color(0xFFD1D5DB)
    val Light500: Color = Color(0xFFD1D5DB)
    val Light400: Color = Color(0xFFDADDE2)
    val Light300: Color = Color(0xFFE0E3E7)
    val Light200: Color = Color(0xFFEAECEE)
    val Light100: Color = Color(0xFFF1F2F4)
    val Light50: Color = Color(0xFFFAFBFB)

    /* Red Colors */
    val Red900: Color = Color(0xFF670505)
    val Red800: Color = Color(0xFF870707)
    val Red700: Color = Color(0xFFAE0909)
    val Red600: Color = Color(0xFFDF0C0C)
    val Red500: Color = Color(0xFFF50D0D)
    val Red400: Color = Color(0xFFF73D3D)
    val Red300: Color = Color(0xFFF85D5D)
    val Red200: Color = Color(0xFFFA9090)
    val Red100: Color = Color(0xFFFCB4B4)
    val Red50: Color = Color(0xFFFEE7E7)

    /* Dark Orange Colors */
    val DarkOrange900: Color = Color(0xFF5B2100)
    val DarkOrange800: Color = Color(0xFF772B00)
    val DarkOrange700: Color = Color(0xFF9A3700)
    val DarkOrange600: Color = Color(0xFFC54700)
    val DarkOrange500: Color = Color(0xFFD94E00)
    val DarkOrange400: Color = Color(0xFFE17133)
    val DarkOrange300: Color = Color(0xFFE68854)
    val DarkOrange200: Color = Color(0xFFEEAE8A)
    val DarkOrange100: Color = Color(0xFFF3C8B0)
    val DarkOrange50: Color = Color(0xFFFFEBE1)

    /* Orange Colors */
    val Orange900: Color = Color(0xFF6A3B00)
    val Orange800: Color = Color(0xFF8B4D00)
    val Orange700: Color = Color(0xFFB46300)
    val Orange600: Color = Color(0xFFE67F00)
    val Orange500: Color = Color(0xFFFD8C00)
    val Orange400: Color = Color(0xFFFDA333)
    val Orange300: Color = Color(0xFFFEB254)
    val Orange200: Color = Color(0xFFFECA8A)
    val Orange100: Color = Color(0xFFFEDBB0)
    val Orange50: Color = Color(0xFFFFEFDB)

    /* Yellow Colors */
    val Yellow900: Color = Color(0xFF6A5300)
    val Yellow800: Color = Color(0xFF8B6C00)
    val Yellow700: Color = Color(0xFFB48C00)
    val Yellow600: Color = Color(0xFFE6B300)
    val Yellow500: Color = Color(0xFFFDC500)
    val Yellow400: Color = Color(0xFFFDD133)
    val Yellow300: Color = Color(0xFFFED854)
    val Yellow200: Color = Color(0xFFFEE48A)
    val Yellow100: Color = Color(0xFFFEEDB0)
    val Yellow50: Color = Color(0xFFFFF9E6)

    /* Pastel Green Colors */
    val PastelGreen900: Color = Color(0xFF0F4E26)
    val PastelGreen800: Color = Color(0xFF1A6234)
    val PastelGreen700: Color = Color(0xFF1D763D)
    val PastelGreen600: Color = Color(0xFF1A9747)
    val PastelGreen500: Color = Color(0xFF24B057)
    val PastelGreen400: Color = Color(0xFF1CBD66)
    val PastelGreen300: Color = Color(0xFF38D571)
    val PastelGreen200: Color = Color(0xFF49D27A)
    val PastelGreen100: Color = Color(0xFF56E598)
    val PastelGreen50: Color = Color(0xFFB5FFD7)

    /* Purple Colors */
    val Purple900: Color = Color(0xFF3C1B79)
    val Purple800: Color = Color(0xFF42198E)
    val Purple700: Color = Color(0xFF5223A9)
    val Purple600: Color = Color(0xFF642EC9)
    val Purple500: Color = Color(0xFF8250DF)
    val Purple400: Color = Color(0xFF8F5EEA)
    val Purple300: Color = Color(0xFF9E6DF9)
    val Purple200: Color = Color(0xFFA879FF)
    val Purple100: Color = Color(0xFFB892FF)
    val Purple50: Color = Color(0xFFD3BCFF)

    /* Ember Colors */
    val Ember900: Color = Color(0xFF7A3A23)
    val Ember800: Color = Color(0xFFA73E18)
    val Ember700: Color = Color(0xFFB44821)
    val Ember600: Color = Color(0xFFCE4D1E)
    val Ember500: Color = Color(0xFFEF5D28)
    val Ember400: Color = Color(0xFFFF7341)
    val Ember300: Color = Color(0xFFFF7D4E)
    val Ember200: Color = Color(0xFFF8906A)
    val Ember100: Color = Color(0xFFFFA180)
    val Ember50: Color = Color(0xFFFFCEBC)

    /* Deep Red Colors */
    val DeepRed900: Color = Color(0xFF660B16)
    val DeepRed800: Color = Color(0xFF790C18)
    val DeepRed700: Color = Color(0xFF8A0A19)
    val DeepRed600: Color = Color(0xFF9C0315)
    val DeepRed500: Color = Color(0xFFB60216)
    val DeepRed400: Color = Color(0xFFE91F36)
    val DeepRed300: Color = Color(0xFFE53246)
    val DeepRed200: Color = Color(0xFFF24356)
    val DeepRed100: Color = Color(0xFFF66C7C)
    val DeepRed50: Color = Color(0xFFFFB1BA)

    /* Magenta Colors */
    val Magenta900: Color = Color(0xFF700037)
    val Magenta800: Color = Color(0xFF870F4A)
    val Magenta700: Color = Color(0xFF9E1D5D)
    val Magenta600: Color = Color(0xFFAF1F66)
    val Magenta500: Color = Color(0xFFDB2780)
    val Magenta400: Color = Color(0xFFFF53A8)
    val Magenta300: Color = Color(0xFFFD74B8)
    val Magenta200: Color = Color(0xFFFF9CCD)
    val Magenta100: Color = Color(0xFFFFAAD4)
    val Magenta50: Color = Color(0xFFFFD6EA)

    /* Zinc Colors */
    val Zinc900: Color = Color(0xFF353538)
    val Zinc800: Color = Color(0xFF46464A)
    val Zinc700: Color = Color(0xFF5A5A5F)
    val Zinc600: Color = Color(0xFF74747A)
    val Zinc500: Color = Color(0xFF7F7F86)
    val Zinc400: Color = Color(0xFF99999E)
    val Zinc300: Color = Color(0xFFA9A9AE)
    val Zinc200: Color = Color(0xFFC4C4C7)
    val Zinc100: Color = Color(0xFFD7D7D9)
    val Zinc50: Color = Color(0xFFF2F2F3)

    /* Blue Colors */
    val Blue900: Color = Color(0xFF17307C)
    val Blue800: Color = Color(0xFF153596)
    val Blue700: Color = Color(0xFF2144AE)
    val Blue600: Color = Color(0xFF1E52EF)
    val Blue500: Color = Color(0xFF3265FE)
    val Blue400: Color = Color(0xFF4674FF)
    val Blue300: Color = Color(0xFF5680FF)
    val Blue200: Color = Color(0xFF6B90FF)
    val Blue100: Color = Color(0xFF86A4FF)
    val Blue50: Color = Color(0xFFA9BEFF)

    /* Pink Colors */
    val Pink900: Color = Color(0xFF880E4F)
    val Pink800: Color = Color(0xFFAD1457)
    val Pink700: Color = Color(0xFFC2185B)
    val Pink600: Color = Color(0xFFD81B60)
    val Pink500: Color = Color(0xFFE91E63)
    val Pink400: Color = Color(0xFFEC407A)
    val Pink300: Color = Color(0xFFF06292)
    val Pink200: Color = Color(0xFFF48FB1)
    val Pink100: Color = Color(0xFFF8BBD0)
    val Pink50: Color = Color(0xFFFCE4EC)

    /* Cyan Colors */
    val Cyan900: Color = Color(0xFF006064)
    val Cyan800: Color = Color(0xFF00838F)
    val Cyan700: Color = Color(0xFF00838F)
    val Cyan600: Color = Color(0xFF00ACC1)
    val Cyan500: Color = Color(0xFF00BCD4)
    val Cyan400: Color = Color(0xFF26C6DA)
    val Cyan300: Color = Color(0xFF4DD0E1)
    val Cyan200: Color = Color(0xFF80DEEA)
    val Cyan100: Color = Color(0xFFB2EBF2)
    val Cyan50: Color = Color(0xFFE0F7FA)

    /* Sky Colors */
    val Sky900: Color = Color(0xFF0C4A6E)
    val Sky800: Color = Color(0xFF075985)
    val Sky700: Color = Color(0xFF0369A1)
    val Sky600: Color = Color(0xFF0284C7)
    val Sky500: Color = Color(0xFF0EA5E9)
    val Sky400: Color = Color(0xFF38BDF8)
    val Sky300: Color = Color(0xFF7DD3FC)
    val Sky200: Color = Color(0xFFBAE6FD)
    val Sky100: Color = Color(0xFFE0F2FE)
    val Sky50: Color = Color(0xFFF0F9FF)

    /* Emerald Colors */
    val Emerald900: Color = Color(0xFF064E3B)
    val Emerald800: Color = Color(0xFF065F46)
    val Emerald700: Color = Color(0xFF047857)
    val Emerald600: Color = Color(0xFF059669)
    val Emerald500: Color = Color(0xFF10B981)
    val Emerald400: Color = Color(0xFF34D399)
    val Emerald300: Color = Color(0xFF6EE7B7)
    val Emerald200: Color = Color(0xFFA7F3D0)
    val Emerald100: Color = Color(0xFFD1FAE5)
    val Emerald50: Color = Color(0xFFECFDF5)

    /* Gray Colors */
    val Gray900: Color = Color(0xFF111827)
    val Gray800: Color = Color(0xFF1F2937)
    val Gray700: Color = Color(0xFF374151)
    val Gray600: Color = Color(0xFF4B5563)
    val Gray500: Color = Color(0xFF6B7280)
    val Gray400: Color = Color(0xFF9CA3AF)
    val Gray300: Color = Color(0xFFD1D5DB)
    val Gray200: Color = Color(0xFFE5E7EB)
    val Gray100: Color = Color(0xFFF3F4F6)
    val Gray50: Color = Color(0xFFF9FAFB)

    /* Neutral Colors */
    val Neutral900: Color = Color(0xFF1C1917)
    val Neutral800: Color = Color(0xFF292524)
    val Neutral700: Color = Color(0xFF44403C)
    val Neutral600: Color = Color(0xFF57534E)
    val Neutral500: Color = Color(0xFF78716C)
    val Neutral400: Color = Color(0xFFA8A29E)
    val Neutral300: Color = Color(0xFFD6D3D1)
    val Neutral200: Color = Color(0xFFE7E5E4)
    val Neutral100: Color = Color(0xFFF5F5F4)
    val Neutral50: Color = Color(0xFFFAFAF9)

    /* Text Light */
    object TextLight : TextColors {
        /* Text Light Colors */
        override val Active: Color = Color(0xDEFFFFFF)
        override val Inactive: Color = Color(0x99FFFFFF)
        override val Disabled: Color = Color(0x61FFFFFF)
    }

    /* Text Dark */
    object TextDark : TextColors {
        /* Text Dark Colors */
        override val Active: Color = Color(0xDE000000)
        override val Inactive: Color = Color(0x99000000)
        override val Disabled: Color = Color(0x61000000)
    }

}

object SeverityColors {

    /* Safe Colors */
    val Safe50 = BaseColors.PastelGreen50
    val Safe100 = BaseColors.PastelGreen100
    val Safe200 = BaseColors.PastelGreen200
    val Safe300 = BaseColors.PastelGreen300
    val Safe400 = BaseColors.PastelGreen400
    val Safe500 = BaseColors.PastelGreen500
    val Safe600 = BaseColors.PastelGreen600
    val Safe700 = BaseColors.PastelGreen700
    val Safe800 = BaseColors.PastelGreen800
    val Safe900 = BaseColors.PastelGreen900

    /* Warning Colors */
    val Warning50 = BaseColors.Yellow50
    val Warning100 = BaseColors.Yellow100
    val Warning200 = BaseColors.Yellow200
    val Warning300 = BaseColors.Yellow300
    val Warning400 = BaseColors.Yellow400
    val Warning500 = BaseColors.Yellow500
    val Warning600 = BaseColors.Yellow600
    val Warning700 = BaseColors.Yellow700
    val Warning800 = BaseColors.Yellow800
    val Warning900 = BaseColors.Yellow900

    /* Medium Colors */
    val Medium50 = BaseColors.Orange50
    val Medium100 = BaseColors.Orange100
    val Medium200 = BaseColors.Orange200
    val Medium300 = BaseColors.Orange300
    val Medium400 = BaseColors.Orange400
    val Medium500 = BaseColors.Orange500
    val Medium600 = BaseColors.Orange600
    val Medium700 = BaseColors.Orange700
    val Medium800 = BaseColors.Orange800
    val Medium900 = BaseColors.Orange900

    /* Danger Colors */
    val Danger50 = BaseColors.DarkOrange50
    val Danger100 = BaseColors.DarkOrange100
    val Danger200 = BaseColors.DarkOrange200
    val Danger300 = BaseColors.DarkOrange300
    val Danger400 = BaseColors.DarkOrange400
    val Danger500 = BaseColors.DarkOrange500
    val Danger600 = BaseColors.DarkOrange600
    val Danger700 = BaseColors.DarkOrange700
    val Danger800 = BaseColors.DarkOrange800
    val Danger900 = BaseColors.DarkOrange900

    /* Critical Colors */
    val Critical50 = BaseColors.Red50
    val Critical100 = BaseColors.Red100
    val Critical200 = BaseColors.Red200
    val Critical300 = BaseColors.Red300
    val Critical400 = BaseColors.Red400
    val Critical500 = BaseColors.Red500
    val Critical600 = BaseColors.Red600
    val Critical700 = BaseColors.Red700
    val Critical800 = BaseColors.Red800
    val Critical900 = BaseColors.Red900
}


object SystemColors {

    val CustomBackdrop:Color = Color(0xB2000000)

    /* Primary Colors */
    val Primary50 = BaseColors.Blue50
    val Primary100 = BaseColors.Blue100
    val Primary200 = BaseColors.Blue200
    val Primary300 = BaseColors.Blue300
    val Primary400 = BaseColors.Blue400
    val Primary500 = BaseColors.Blue500
    val Primary600 = BaseColors.Blue600
    val Primary700 = BaseColors.Blue700
    val Primary800 = BaseColors.Blue800
    val Primary900 = BaseColors.Blue900

    /* Secondary Colors */
    val Secondary50 = BaseColors.Neutral50
    val Secondary100 = BaseColors.Neutral100
    val Secondary200 = BaseColors.Neutral200
    val Secondary300 = BaseColors.Neutral300
    val Secondary400 = BaseColors.Neutral400
    val Secondary500 = BaseColors.Neutral500
    val Secondary600 = BaseColors.Neutral600
    val Secondary700 = BaseColors.Neutral700
    val Secondary800 = BaseColors.Neutral800
    val Secondary900 = BaseColors.Neutral900

    /* Info Colors */
    val Info50 = BaseColors.Sky50
    val Info100 = BaseColors.Sky100
    val Info200 = BaseColors.Sky200
    val Info300 = BaseColors.Sky300
    val Info400 = BaseColors.Sky400
    val Info500 = BaseColors.Sky500
    val Info600 = BaseColors.Sky600
    val Info700 = BaseColors.Sky700
    val Info800 = BaseColors.Sky800
    val Info900 = BaseColors.Sky900

    /* Success Colors */
    val Success50 = BaseColors.PastelGreen50
    val Success100 = BaseColors.PastelGreen100
    val Success200 = BaseColors.PastelGreen200
    val Success300 = BaseColors.PastelGreen300
    val Success400 = BaseColors.PastelGreen400
    val Success500 = BaseColors.PastelGreen500
    val Success600 = BaseColors.PastelGreen600
    val Success700 = BaseColors.PastelGreen700
    val Success800 = BaseColors.PastelGreen800
    val Success900 = BaseColors.PastelGreen900

    /* Warning Colors */
    val Warning50 = BaseColors.Orange50
    val Warning100 = BaseColors.Orange100
    val Warning200 = BaseColors.Orange200
    val Warning300 = BaseColors.Orange300
    val Warning400 = BaseColors.Orange400
    val Warning500 = BaseColors.Orange500
    val Warning600 = BaseColors.Orange600
    val Warning700 = BaseColors.Orange700
    val Warning800 = BaseColors.Orange800
    val Warning900 = BaseColors.Orange900

    /* Error Colors */
    val Error50 = BaseColors.Red50
    val Error100 = BaseColors.Red100
    val Error200 = BaseColors.Red200
    val Error300 = BaseColors.Red300
    val Error400 = BaseColors.Red400
    val Error500 = BaseColors.Red500
    val Error600 = BaseColors.Red600
    val Error700 = BaseColors.Red700
    val Error800 = BaseColors.Red800
    val Error900 = BaseColors.Red900

    val Severity = SeverityColors

    /* Phishing Colors */
    val Phishing50 = BaseColors.Purple50
    val Phishing100 = BaseColors.Purple100
    val Phishing200 = BaseColors.Purple200
    val Phishing300 = BaseColors.Purple300
    val Phishing400 = BaseColors.Purple400
    val Phishing500 = BaseColors.Purple500
    val Phishing600 = BaseColors.Purple600
    val Phishing700 = BaseColors.Purple700
    val Phishing800 = BaseColors.Purple800
    val Phishing900 = BaseColors.Purple900

    /* Spam Colors */
    val Spam50 = BaseColors.Ember50
    val Spam100 = BaseColors.Ember100
    val Spam200 = BaseColors.Ember200
    val Spam300 = BaseColors.Ember300
    val Spam400 = BaseColors.Ember400
    val Spam500 = BaseColors.Ember500
    val Spam600 = BaseColors.Ember600
    val Spam700 = BaseColors.Ember700
    val Spam800 = BaseColors.Ember800
    val Spam900 = BaseColors.Ember900

    /* Malware Colors */
    val Malware50 = BaseColors.DeepRed50
    val Malware100 = BaseColors.DeepRed100
    val Malware200 = BaseColors.DeepRed200
    val Malware300 = BaseColors.DeepRed300
    val Malware400 = BaseColors.DeepRed400
    val Malware500 = BaseColors.DeepRed500
    val Malware600 = BaseColors.DeepRed600
    val Malware700 = BaseColors.DeepRed700
    val Malware800 = BaseColors.DeepRed800
    val Malware900 = BaseColors.DeepRed900

    /* Fraud Colors */
    val Fraud50 = BaseColors.Magenta50
    val Fraud100 = BaseColors.Magenta100
    val Fraud200 = BaseColors.Magenta200
    val Fraud300 = BaseColors.Magenta300
    val Fraud400 = BaseColors.Magenta400
    val Fraud500 = BaseColors.Magenta500
    val Fraud600 = BaseColors.Magenta600
    val Fraud700 = BaseColors.Magenta700
    val Fraud800 = BaseColors.Magenta800
    val Fraud900 = BaseColors.Magenta900

    /* Others Colors */
    val Others50 = BaseColors.Zinc50
    val Others100 = BaseColors.Zinc100
    val Others200 = BaseColors.Zinc200
    val Others300 = BaseColors.Zinc300
    val Others400 = BaseColors.Zinc400
    val Others500 = BaseColors.Zinc500
    val Others600 = BaseColors.Zinc600
    val Others700 = BaseColors.Zinc700
    val Others800 = BaseColors.Zinc800
    val Others900 = BaseColors.Zinc900


}


object LightThemeColors : ThemeColors {
    /* Surface Colors */
    override val Surface50 = BaseColors.Light900
    override val Surface100 = BaseColors.Light800
    override val Surface200 = BaseColors.Light700
    override val Surface300 = BaseColors.Light600
    override val Surface400 = BaseColors.Light500
    override val Surface500 = BaseColors.Light400
    override val Surface600 = BaseColors.Light300
    override val Surface700 = BaseColors.Light200
    override val Surface800 = BaseColors.Light100
    override val Surface900 = BaseColors.Light50

    /* Shade Colors */
    override val Shade50 = BaseColors.Zinc900
    override val Shade100 = BaseColors.Zinc800
    override val Shade200 = BaseColors.Zinc700
    override val Shade300 = BaseColors.Zinc600
    override val Shade400 = BaseColors.Zinc500
    override val Shade500 = BaseColors.Zinc400
    override val Shade600 = BaseColors.Zinc300
    override val Shade700 = BaseColors.Zinc200
    override val Shade800 = BaseColors.Zinc100
    override val Shade900 = BaseColors.Zinc50

    /* Border Colors */
    override val BorderPrimary = BaseColors.Blue200
    override val BorderSecondary = BaseColors.Neutral200
    override val BorderInfo = BaseColors.Sky200
    override val BorderSuccess = BaseColors.PastelGreen200
    override val BorderWarning = BaseColors.Orange200
    override val BorderError = BaseColors.Red200
    override val BorderDivider = BaseColors.Zinc200
    override val BorderDisabled = BaseColors.Neutral200

    /* Text Colors */
    override val Text = BaseColors.TextDark
    override val Primary: ActionColors = object : ActionColors {
        /* Primary Light Colors */
        override val Main = SystemColors.Primary500
        override val Hover = SystemColors.Primary700
        override val Pressed = SystemColors.Primary800
        override val Focused = SystemColors.Primary700
        override val Disabled = SystemColors.Primary300

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Primary50
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Primary50
    }
    override val Secondary: ActionColors = object : ActionColors {
        /* Secondary Light Colors */
        override val Main = SystemColors.Secondary500
        override val Hover = SystemColors.Secondary600
        override val Pressed = SystemColors.Secondary700
        override val Focused = SystemColors.Secondary600
        override val Disabled = SystemColors.Secondary300

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Secondary200
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Secondary100
    }
    override val Info: ActionColors = object : ActionColors {
        /* Info Light Colors */
        override val Main = SystemColors.Info500
        override val Hover = SystemColors.Info700
        override val Pressed = SystemColors.Info800
        override val Focused = SystemColors.Info700
        override val Disabled = SystemColors.Info300

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Info50
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Info50
    }
    override val Success: ActionColors = object : ActionColors {
        /* Success Light Colors */
        override val Main = SystemColors.Success500
        override val Hover = SystemColors.Success700
        override val Pressed = SystemColors.Success800
        override val Focused = SystemColors.Success700
        override val Disabled = SystemColors.Success100

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Success100
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Success50
    }
    override val Warning: ActionColors = object : ActionColors {
        /* Warning Light Colors */
        override val Main = SystemColors.Warning500
        override val Hover = SystemColors.Warning700
        override val Pressed = SystemColors.Warning800
        override val Focused = SystemColors.Warning700
        override val Disabled = SystemColors.Warning300

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Warning100
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Warning50
    }
    override val Error: ActionColors = object : ActionColors {
        /* Error Light Colors */
        override val Main = SystemColors.Error500
        override val Hover = SystemColors.Error700
        override val Pressed = SystemColors.Error800
        override val Focused = SystemColors.Error700
        override val Disabled = SystemColors.Error300

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Error100
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Error50
    }
    override val Severity: ActionSeverityColors = object : ActionSeverityColors {
        override val Safe: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Safe500
            override val Hover: Color = SeverityColors.Safe700
            override val Pressed: Color = SeverityColors.Safe800
            override val Focused: Color = SeverityColors.Safe700
            override val Disabled: Color = SeverityColors.Safe300

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Safe100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Safe50

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Safe50
                override val TextMain: Color = SeverityColors.Safe900
            }
        }
        override val Warning: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Warning500
            override val Hover: Color = SeverityColors.Warning700
            override val Pressed: Color = SeverityColors.Warning800
            override val Focused: Color = SeverityColors.Warning700
            override val Disabled: Color = SeverityColors.Warning300

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Warning100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Warning50

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Warning100
                override val TextMain: Color = SeverityColors.Warning900
            }
        }
        override val Medium: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Medium500
            override val Hover: Color = SeverityColors.Medium700
            override val Pressed: Color = SeverityColors.Medium800
            override val Focused: Color = SeverityColors.Medium700
            override val Disabled: Color = SeverityColors.Medium300

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Medium100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Medium50

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Medium100
                override val TextMain: Color = SeverityColors.Medium900
            }
        }
        override val Danger: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Danger500
            override val Hover: Color = SeverityColors.Danger700
            override val Pressed: Color = SeverityColors.Danger800
            override val Focused: Color = SeverityColors.Danger700
            override val Disabled: Color = SeverityColors.Danger300

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Danger100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Danger50

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Danger100
                override val TextMain: Color = SeverityColors.Danger900
            }
        }
        override val Critical: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Critical500
            override val Hover: Color = SeverityColors.Critical700
            override val Pressed: Color = SeverityColors.Critical800
            override val Focused: Color = SeverityColors.Critical600
            override val Disabled: Color = SeverityColors.Critical300

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Critical100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Critical50

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Critical100
                override val TextMain: Color = SeverityColors.Critical900
            }

        }

    }

}

object DarkThemeColors : ThemeColors {
    /* Surface Colors */
    override val Surface50 = BaseColors.Dark50
    override val Surface100 = BaseColors.Dark100
    override val Surface200 = BaseColors.Dark200
    override val Surface300 = BaseColors.Dark300
    override val Surface400 = BaseColors.Dark400
    override val Surface500 = BaseColors.Dark500
    override val Surface600 = BaseColors.Dark600
    override val Surface700 = BaseColors.Dark700
    override val Surface800 = BaseColors.Dark800
    override val Surface900 = BaseColors.Dark900

    /* Shade Colors */
    override val Shade50 = BaseColors.Zinc50
    override val Shade100 = BaseColors.Zinc100
    override val Shade200 = BaseColors.Zinc200
    override val Shade300 = BaseColors.Zinc300
    override val Shade400 = BaseColors.Zinc400
    override val Shade500 = BaseColors.Zinc500
    override val Shade600 = BaseColors.Zinc600
    override val Shade700 = BaseColors.Zinc700
    override val Shade800 = BaseColors.Zinc800
    override val Shade900 = BaseColors.Zinc900

    /* Border Colors */
    override val BorderPrimary = BaseColors.Blue800
    override val BorderSecondary = BaseColors.Neutral800
    override val BorderInfo = BaseColors.Sky800
    override val BorderSuccess = BaseColors.PastelGreen800
    override val BorderWarning = BaseColors.Orange800
    override val BorderError = BaseColors.Red800
    override val BorderDivider = BaseColors.Zinc800
    override val BorderDisabled = BaseColors.Neutral800

    /* Text Colors */
    override val Text = BaseColors.TextLight
    override val Primary: ActionColors = object : ActionColors {
        /* Primary Dark Colors */
        override val Main = SystemColors.Primary500
        override val Hover = SystemColors.Primary400
        override val Pressed = SystemColors.Primary700
        override val Focused = SystemColors.Primary400
        override val Disabled = SystemColors.Primary900

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Primary50
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Primary600
    }
    override val Secondary: ActionColors = object : ActionColors {
        /* Secondary Dark Colors */
        override val Main = SystemColors.Secondary700
        override val Hover = SystemColors.Secondary600
        override val Pressed = SystemColors.Secondary700
        override val Focused = SystemColors.Secondary600
        override val Disabled = SystemColors.Secondary800

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Secondary200
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Secondary600
    }
    override val Info: ActionColors = object : ActionColors {
        /* Info Dark Colors */
        override val Main = SystemColors.Info500
        override val Hover = SystemColors.Info400
        override val Pressed = SystemColors.Info700
        override val Focused = SystemColors.Info400
        override val Disabled = SystemColors.Info900

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Info50
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Info600
    }
    override val Success: ActionColors = object : ActionColors {
        /* Success Dark Colors */
        override val Main = SystemColors.Success500
        override val Hover = SystemColors.Success600
        override val Pressed = SystemColors.Success700
        override val Focused = SystemColors.Success600
        override val Disabled = SystemColors.Success900

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Success100
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Success600
    }
    override val Warning: ActionColors = object : ActionColors {
        /* Warning Dark Colors */
        override val Main = SystemColors.Warning500
        override val Hover = SystemColors.Warning600
        override val Pressed = SystemColors.Warning700
        override val Focused = SystemColors.Warning600
        override val Disabled = SystemColors.Warning900

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Warning100
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Warning600
    }
    override val Error: ActionColors = object : ActionColors {
        /* Error Dark Colors */
        override val Main = SystemColors.Error500
        override val Hover = SystemColors.Error600
        override val Pressed = SystemColors.Error700
        override val Focused = SystemColors.Error600
        override val Disabled = SystemColors.Error900

        override val TextMain = Color.White
        override val TextHover = BaseColors.Neutral50
        override val TextPressed = SystemColors.Error100
        override val TextFocused = BaseColors.Neutral50
        override val TextDisabled = SystemColors.Error600
    }
    override val Severity: ActionSeverityColors = object : ActionSeverityColors {
        override val Safe: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Safe500
            override val Hover: Color = SeverityColors.Safe600
            override val Pressed: Color = SeverityColors.Safe700
            override val Focused: Color = SeverityColors.Safe600
            override val Disabled: Color = SeverityColors.Safe900

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Safe100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Safe600

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Safe900
                override val TextMain: Color = SeverityColors.Safe50
            }
        }
        override val Warning: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Warning500
            override val Hover: Color = SeverityColors.Warning600
            override val Pressed: Color = SeverityColors.Warning700
            override val Focused: Color = SeverityColors.Warning600
            override val Disabled: Color = SeverityColors.Warning900

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Warning100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Warning600

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Warning900
                override val TextMain: Color = SeverityColors.Warning100
            }
        }
        override val Medium: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Medium500
            override val Hover: Color = SeverityColors.Medium600
            override val Pressed: Color = SeverityColors.Medium700
            override val Focused: Color = SeverityColors.Medium600
            override val Disabled: Color = SeverityColors.Medium900

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Medium100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Medium600

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Medium900
                override val TextMain: Color = SeverityColors.Medium100
            }
        }
        override val Danger: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Danger500
            override val Hover: Color = SeverityColors.Danger600
            override val Pressed: Color = SeverityColors.Danger700
            override val Focused: Color = SeverityColors.Danger600
            override val Disabled: Color = SeverityColors.Danger900

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Danger100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Danger600

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Danger900
                override val TextMain: Color = SeverityColors.Danger100
            }
        }
        override val Critical: SeverityActionColors = object : SeverityActionColors {
            override val Main: Color = SeverityColors.Critical500
            override val Hover: Color = SeverityColors.Critical600
            override val Pressed: Color = SeverityColors.Critical700
            override val Focused: Color = SeverityColors.Critical600
            override val Disabled: Color = SeverityColors.Critical900

            override val TextMain: Color = Color.White
            override val TextHover: Color = BaseColors.Neutral50
            override val TextPressed: Color = SeverityColors.Critical100
            override val TextFocused: Color = BaseColors.Neutral50
            override val TextDisabled: Color = SeverityColors.Critical600

            override val Ghosted: GhostedColors = object : GhostedColors {
                override val Main: Color = SeverityColors.Critical900
                override val TextMain: Color = SeverityColors.Critical100
            }
        }

    }

}

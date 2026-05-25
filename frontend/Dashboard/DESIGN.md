---
name: Sistema Cozinha Comunitária
colors:
  surface: '#f9f9f9'
  surface-dim: '#dadada'
  surface-bright: '#f9f9f9'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f3f3f3'
  surface-container: '#eeeeee'
  surface-container-high: '#e8e8e8'
  surface-container-highest: '#e2e2e2'
  on-surface: '#1a1c1c'
  on-surface-variant: '#40493d'
  inverse-surface: '#2f3131'
  inverse-on-surface: '#f1f1f1'
  outline: '#707a6c'
  outline-variant: '#bfcaba'
  surface-tint: '#1b6d24'
  primary: '#0d631b'
  on-primary: '#ffffff'
  primary-container: '#2e7d32'
  on-primary-container: '#cbffc2'
  inverse-primary: '#88d982'
  secondary: '#2a6b2c'
  on-secondary: '#ffffff'
  secondary-container: '#acf4a4'
  on-secondary-container: '#307231'
  tertiary: '#1d622b'
  on-tertiary: '#ffffff'
  tertiary-container: '#387b41'
  on-tertiary-container: '#c7ffc5'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#a3f69c'
  primary-fixed-dim: '#88d982'
  on-primary-fixed: '#002204'
  on-primary-fixed-variant: '#005312'
  secondary-fixed: '#acf4a4'
  secondary-fixed-dim: '#91d78a'
  on-secondary-fixed: '#002203'
  on-secondary-fixed-variant: '#0c5216'
  tertiary-fixed: '#abf4ac'
  tertiary-fixed-dim: '#90d792'
  on-tertiary-fixed: '#002107'
  on-tertiary-fixed-variant: '#07521d'
  background: '#f9f9f9'
  on-background: '#1a1c1c'
  surface-variant: '#e2e2e2'
typography:
  headline-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: -0.02em
  headline-lg-mobile:
    fontFamily: Plus Jakarta Sans
    fontSize: 24px
    fontWeight: '700'
    lineHeight: 32px
    letterSpacing: -0.02em
  headline-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
    letterSpacing: -0.01em
  headline-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
  body-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  body-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
  label-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 12px
    fontWeight: '600'
    lineHeight: 16px
    letterSpacing: 0.05em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  sidebar-width: 280px
  navbar-height: 72px
  gutter: 24px
  margin-mobile: 16px
  margin-desktop: 40px
  stack-sm: 8px
  stack-md: 16px
  stack-lg: 32px
---

## Brand & Style
This design system is built on the pillars of efficiency, nourishment, and community trust. It facilitates the complex logistics of community kitchens while maintaining a warm, approachable aesthetic that reflects its social mission.

The visual style is **Modern Minimalism**. By leveraging generous whitespace and a restricted color palette, the UI reduces cognitive load for staff and administrators. The design avoids unnecessary decorative elements, opting instead for structural clarity and soft, organic shapes that evoke a sense of safety and friendliness. The resulting experience is professional and systematic, yet deeply human.

## Colors
The palette is rooted in a "Growth Green" that symbolizes health and vitality. 

- **Primary (#2E7D32):** Used for main actions, active navigation states, and brand identifiers. It carries enough contrast to be highly accessible for functional UI elements.
- **Surface (#F5F5F5):** Applied to large layout containers and backgrounds to differentiate sections without the harshness of pure white borders.
- **Background (#FFFFFF):** The base for all content cards and input fields to ensure maximum readability and a "clean" laboratory feel.
- **Semantic Accents:** Use soft variations of the primary green for success states, and standard professional reds/ambers for alerts, always maintaining a desaturated, professional tone.

## Typography
**Plus Jakarta Sans** is the sole typeface for the design system. Its modern, geometric curves and open apertures provide excellent legibility for data-heavy SaaS interfaces while maintaining the "friendly professional" tone required.

- **Headlines:** Utilize a tighter letter-spacing and heavier weights to create a strong visual anchor for page titles.
- **Body:** Standardized at 14px and 16px to accommodate complex tables and forms without sacrificing readability.
- **Labels:** Used for table headers and status badges, appearing in semi-bold with slight letter-spacing for quick scanning.

## Layout & Spacing
The design system employs a **Fixed Sidebar + Fluid Content** model. 

- **Sidebar:** A persistent 280px vertical navigation bar on the left ensures critical tools (Inventory, Menu Planning, Beneficiaries) are always one click away.
- **Top Navbar:** A 72px high bar for global search, notifications, and profile management.
- **Content Area:** A fluid 12-column grid. On desktop, content is contained within high margins (40px) to prevent line lengths from becoming unreadable.
- **Rhythm:** An 8px base unit governs all spacing. Components use "Stack" logic (8, 16, 32px) to define vertical relationships, ensuring consistent breathing room across the application.

## Elevation & Depth
Depth is communicated through **Ambient Shadows** and tonal layering rather than heavy borders.

1.  **Level 0 (Background):** Pure #FFFFFF or #F5F5F5 surface.
2.  **Level 1 (Cards/Tables):** White surfaces with a very soft, diffused shadow (Offset: 0, 4px; Blur: 20px; Color: rgba(0,0,0, 0.04)). This makes content appear to float subtly above the neutral background.
3.  **Level 2 (Dropdowns/Modals):** Higher contrast shadows with a 12% opacity to indicate temporary interaction layers that require immediate focus.

The fixed sidebar uses a "Level 0" treatment with a subtle 1px right border in #E0E0E0 to maintain a flat, architectural feel.

## Shapes
The shape language is characterized by a "High Radius" philosophy. 

All primary UI containers (Cards, Modals, Buttons) utilize the `rounded-lg` (16px) or `rounded-xl` (24px) property. This softening of the corners removes the "institutional" feel common in government or logistics software, making the platform feel modern and accessible.

Buttons and small input fields use a consistent 8px radius to maintain a compact, functional look while still aligning with the overall rounded aesthetic.

## Components
- **Cards:** The primary container. Always white with a 16px corner radius and a soft shadow. Padding is generous (24px) to emphasize the minimalist aesthetic.
- **Buttons:** 
    - *Primary:* Solid #2E7D32 with white text.
    - *Secondary:* Ghost style with #2E7D32 border and text.
    - *Tertiary:* Flat text for low-priority actions.
- **Status Badges:** Pill-shaped (fully rounded) with low-saturation background tints and high-saturation text (e.g., "Active" uses a 10% opacity green background with 100% primary green text).
- **Tables:** No vertical lines. Only subtle horizontal dividers in #F5F5F5. The header row is always a light gray tint with uppercase labels.
- **Inputs:** Outlined style with a 1px #E0E0E0 border that turns #2E7D32 on focus. Labels sit clearly above the field, never as placeholders only.
- **Sidebar Items:** Large hit areas (48px height) with 8px rounded corners for the active state highlight.